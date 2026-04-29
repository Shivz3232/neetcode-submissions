class Twitter {
    private final Map<Integer, Set<Integer>> followMap;
    private final Map<Integer, List<Tweet>> tweetsMap;
    private int time;

    public Twitter() {
        this.followMap = new HashMap<>();
        this.tweetsMap = new HashMap<>();
        this.time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        List<Tweet> tweets = tweetsMap.getOrDefault(userId, new ArrayList<>());

        if (tweets.isEmpty()) {
            tweets.add(new Tweet(tweetId, ++time));
            tweetsMap.put(userId, tweets);
        } else {
            // int[] lastTweet = tweets.get(tweets.size() - 1);
            // tweets.add(new int[]{lastTweet[0] + 1, tweetId});
            tweets.add(new Tweet(tweetId, ++time));
        }
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (Tweet t : tweetsMap.getOrDefault(userId, List.of())) pq.add(t);
        for (int followeeId : followMap.getOrDefault(userId, Set.of())) {
            for (Tweet t : tweetsMap.getOrDefault(followeeId, List.of())) pq.add(t);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; !pq.isEmpty() && i < 10; i++) {
            result.add(pq.poll().id);
        }

        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        Set<Integer> followees = followMap.getOrDefault(followerId, new HashSet<>());
        followees.add(followeeId);
        followMap.put(followerId, followees);
    }
    
    public void unfollow(int followerId, int followeeId) {
        followMap.get(followerId).remove(followeeId);
    }

    private static class Tweet implements Comparable<Tweet> {
        public final int id;
        public final int timestamp;

        public Tweet(int id, int timestamp) {
            this.id = id;
            this.timestamp = timestamp;
        }

        @Override
        public int compareTo(Tweet o) {
            return Integer.compare(timestamp, o.timestamp);
        }
    }
}
