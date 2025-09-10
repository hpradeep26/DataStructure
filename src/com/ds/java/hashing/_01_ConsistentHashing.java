package com.ds.java.hashing;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class _01_ConsistentHashing {
	// https://github.com/ashishps1/awesome-system-design-resources/blob/main/implementations/java/consistent_hashing/ConsistentHashing.java
	 private final int numReplicas; // Number of virtual nodes per server
	 private final TreeMap<Long, String> ring; // Hash ring storing virtual nodes
	 private final Set<String> servers; // Set of physical servers
	 
	 public _01_ConsistentHashing(List<String> servers, int numReplicas) {
	        this.numReplicas = numReplicas;
	        this.ring = new TreeMap<>();
	        this.servers = new HashSet<>();

	        // Add each server to the hash ring
	        for (String server : servers) {
	            addServer(server);
	        }
	    }
	 
	 private long hash(String key) {
	        try {
	            MessageDigest md = MessageDigest.getInstance("MD5");
	            md.update(key.getBytes());
	            byte[] digest = md.digest();
	            return ((long) (digest[0] & 0xFF) << 24) |
	                   ((long) (digest[1] & 0xFF) << 16) |
	                   ((long) (digest[2] & 0xFF) << 8) |
	                   ((long) (digest[3] & 0xFF));
	        } catch (NoSuchAlgorithmException e) {
	            throw new RuntimeException("MD5 algorithm not found", e);
	        }
	    }
	 
	 public void addServer(String server) {
	        servers.add(server);
	        for (int i = 0; i < numReplicas; i++) {
	            long hash = hash(server + "-" + i); // Unique hash for each virtual node
	            ring.put(hash, server);
	        }
	    }
	 
	 public void removeServer(String server) {
	        if (servers.remove(server)) {
	            for (int i = 0; i < numReplicas; i++) {
	                long hash = hash(server + "-" + i);
	                ring.remove(hash);
	            }
	        }
	    }
	 
	 public String getServer(String key) {
	        if (ring.isEmpty()) {
	            return null; // No servers available
	        }

	        long hash = hash(key);
	        // Find the closest server in a clockwise direction
	        Map.Entry<Long, String> entry = ring.ceilingEntry(hash);
	        if (entry == null) {
	            // If we exceed the highest node, wrap around to the first node
	            entry = ring.firstEntry();
	        }
	        return entry.getValue();
	    }
	 
	public static void main(String[] args) {
		 List<String> servers = Arrays.asList("S0", "S1", "S2");
		 _01_ConsistentHashing consistentHashing = new _01_ConsistentHashing(servers, 2);
		 
		// Step 2: Assign requests (keys) to servers
	        System.out.println("UserA is assigned to: " + consistentHashing.getServer("UserA"));
	        System.out.println("UserB is assigned to: " + consistentHashing.getServer("UserB"));
	        System.out.println("UserC is assigned to: " + consistentHashing.getServer("UserC"));
	     
	        // Step 3: Add a new server dynamically
	        consistentHashing.addServer("S3");
	        System.out.println("UserA is assigned to: " + consistentHashing.getServer("UserA"));
	        System.out.println("UserB is assigned to: " + consistentHashing.getServer("UserB"));
	        System.out.println("UserB is assigned to: " + consistentHashing.getServer("UserC"));
	        
	        // Step 4: Remove a server dynamically
	        consistentHashing.removeServer("S2");
	        System.out.println("UserA is assigned to: " + consistentHashing.getServer("UserA"));
	        System.out.println("UserB is assigned to: " + consistentHashing.getServer("UserB"));
	        System.out.println("UserB is assigned to: " + consistentHashing.getServer("UserC"));
	}
	//=====================
	/* 1.In a distributed system where nodes (servers) are frequently added or removed, 
	efficiently routing requests becomes challenging.
	2. A common approach is to use hash the request and assign it to a server using Hash(key) mod N,
	  where N is the number of servers.
	 3.However, this method is highly dependent on the number of servers, 
	  and any change in N can lead to significant rehashing, causing a major redistribution of keys (requests).
	 4. Consistent hashing addresses this issue by ensuring that only a small subset of keys need to be reassigned 
	  when nodes are added or removed.
	 5. Popularized by Amazon’s Dynamo paper, it has now become a fundamental technique in distributed databases 
	  like DynamoDB, Cassandra and ScyllaDB.
	*/
	
	//========================
	/* 1. The Problem with Traditional Hashing
	 	Imagine you're building a high-traffic web application that serves millions of users daily. To handle the load efficiently, 
	 	you distribute incoming requests across multiple backend servers using a hash-based load balancer.
	 2.Your system consists of 5 backend servers (S0, S1, S2, S3, S4), 
	 and requests are assigned using a hash function that maps each user's IP address to a specific server.
	
	 3.The process works like this:

		3.1 The load balancer takes a user’s IP address (or session ID).
		
		3.2 A hash function maps the IP to one of the backend servers by taking the sum of bytes in the IP address 
		and computing mod 5 (since we have 5 servers).
		
		3.3 The request is routed to the assigned server, 
		ensuring that the same user is always directed to the same server for session consistency.
	 
	 */
	//**********************
	/*  Everything Works Fine… Until You Scale
		This approach works as long as the number of servers remains constant.
		 But what happens when you add or remove a server?
		 
		 Scenario 1: Adding a New Server (S5)
		 As traffic increases, you decide to scale up by adding a new backend server (S5). 
		 Now, the hash function must be modified to use mod 6 instead of mod 5 since we have 6 servers now.
		 This seemingly simple change completely disrupts the existing mapping,
		 causing most users to be reassigned to different servers.
		 This results into massive rehashing, leading to high overhead, and potential downtime.
		 
		 Scenario 2: Removing a Server (S4)
		 Now, let’s say one of the servers (S4) fails or is removed. 
		 The number of servers drops to 4, forcing the hash function to switch from mod 5 to mod 4.
		 Even though only one server was removed, most users are reassigned to different servers. This can cause:

		 Session Loss: Active users may be logged out or disconnected.

		 Cache invalidation: Cached data becomes irrelevant, increasing database load.

		 Severe performance degradation: The system may struggle to run efficiently.	
		 	
	 */
	
	/* 2. How Consistent Hashing Works 
	   Consistent hashing is a distributed hashing technique used to
	    efficiently distribute data across multiple nodes (servers, caches, etc.).
	    It uses a circular hash space (hash ring) with a large and constant hash space.
	    Both nodes (servers, caches, or databases) and keys (data items) 
	    are mapped to positions on this hash ring using a hash function.
	    
	    In consistent hashing, when the number of nodes changes, only k/n keys need to be reassigned, 
	    where k is the total number of keys and n is the total number of nodes
	    
	    2.1 Constructing the Hash Ring
	    Instead of distributing keys based on Hash(key) mod N, 
	    consistent hashing places both servers and keys on a circular hash ring.
	    
	    - Defining the Hash Space
		  - We use a large, fixed hash space ranging from 0 to 2^32 - 1 (assuming a 32-bit hash function).
		  - This creates a circular structure, where values wrap around after reaching the maximum limit.
		
		- Placing Servers on the Ring
		 - Each server (node) is assigned a position on the hash ring by computing Hash(server_id).
		 - Using the above example with 5 servers (S0, S1, S2, S3, S4), 
		  the hash function distributes them at different positions around the ring.
		
		--Mapping Keys to Servers
			- When a key is added, its position is determined by computing Hash(key).

			- Example: a user’s request is assigned a position on the ring based
			 on the hash of their IP address: Hash(IP Address)

			- We then move clockwise around the ring until we find the next available server.

			- The key (or request) is assigned to this server for storage or retrieval.
		
		2.2 Adding a New Server
			- Suppose we add a new server (S5) to the system.
			- The position of S5 falls between S1 and S2 in the hash ring.
			- S5 takes over all keys (requests) that fall between S1 and S5, which were previously handled by S2.
			- Example: User D’s requests which were originally assigned to S2, will now be redirected to S5.
			- This demonstrates how consistent hashing efficiently redistributes keys with minimal disruption, 
			ensuring that only a small subset of keys are reassigned when new servers are added.
	  
	   2.3 Removing a Node
	   		- When a server, such as S4, fails or is removed from the system:
	   		- All keys previously assigned to S4 are reassigned to the next available server in the ring (S3).
	   		- Only the keys (requests) that were mapped to S4 need to move, while all other keys remain unaffected.
	   		- This results in minimal data movement, unlike traditional hashing 
	   		  where removing a node would require reassigning most keys.
	   
	   3. Virtual Nodes
			--In basic consistent hashing, each server is assigned a single position on the hash ring. However, 
			 this can lead to uneven data distribution, especially when:
			  - The number of servers is small.
			  - Some servers accidentally get clustered together, creating hot spots
			  - A server is removed, causing a sudden load shift to its immediate neighbor.
			 
			 - Virtual nodes (VNodes) are a technique used in consistent hashing to improve load balancing and fault tolerance 
			 by distributing data more evenly across servers.
			 
			 -- How Virtual Nodes Work
			   - Instead of assigning one position per server, each physical server is assigned multiple positions (virtual nodes) 
			   on the hash ring.
			   - Each server is hashed multiple times to different locations on the ring
			   - When a request (key) is hashed, it is assigned to the next virtual node in a clockwise direction.
			   - The request is then routed to the actual server associated with the virtual node.
			   
			---Example (Without Virtual)
			   - Assume we have three physical servers (S1, S2, S3). Without virtual nodes,
			    their positions might be:
			    S1 → Position 10
				S2 → Position 50
				S3 → Position 90
			  - If S1 fails, all its keys must be reassigned to S2, which can create an overload.
			  	
			---Example (With Virtual)
			   - With virtual nodes, each server is hashed multiple times:
			    their positions might be:
			    S1-1 → Position 10
				S1-2 → Position 30
				S1-3 → Position 70
				S2-1 → Position 50
				S2-2 → Position 80
				S2-3 → Position 120
				S3-1 → Position 90
				S3-2 → Position 140
				S3-3 → Position 160
			  - Now, instead of just one point, S1 is represented at multiple positions, making the distribution more even.
			  - If S1 fails, its keys are evenly redistributed among S2 and S3, rather than all going to S2.
	 */
	
}
