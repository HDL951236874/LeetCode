package oop;

import java.util.*;

public class Twitter {
    //the datastructure in the problem can be improved
    public List<Integer> user_pool;
    public Map<Integer, List<Integer>> tweet_contain;
    public List<Integer> time_line;
    public Map<Integer, List<Integer>> friend_contain;

    public Twitter() {
        this.user_pool = new ArrayList<>();
        this.tweet_contain = new HashMap<>();
        this.time_line = new ArrayList<>();
        this.friend_contain = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        if (!user_pool.contains(userId)) initialize(userId);
        if (!tweet_contain.containsKey(userId)) {
            tweet_contain.put(userId, new ArrayList<>(Arrays.asList(tweetId)));
        } else {
            List<Integer> temp = tweet_contain.get(userId);
            temp.add(tweetId);
            tweet_contain.put(userId, temp);
        }
        time_line.add(tweetId);
    }

    public List<Integer> getNewsFeed(int userId) {
        try {
            List<Integer> user_list = new ArrayList<>();
            user_list.addAll(friend_contain.get(userId));
            user_list.add(userId);
            Set<Integer> temp_set = new HashSet<>();
            for (int i = 0; i < user_list.size(); i++) {
                List<Integer> temp_list = this.tweet_contain.get(user_list.get(i));
                for (int j = 0; j < temp_list.size(); j++) {
                    temp_set.add(temp_list.get(j));
                }
            }
            List<Integer> res = new ArrayList<>();
            for (int i = time_line.size() - 1; i >= 0; i--) {
                if (temp_set.contains(time_line.get(i)))
                    res.add(time_line.get(i));
                if (res.size() == 10) break;
            }
            return res;
        } catch (Exception e){
            return new ArrayList<>();
        }
    }

    public void follow(int followerId, int followeeId) {
        if (!user_pool.contains(followerId)) initialize(followerId);
        List<Integer> temp = friend_contain.get(followerId);
        temp.add(followeeId);
        friend_contain.put(followerId, temp);
    }

    public void unfollow(int followerId, int followeeId) {
        List<Integer> temp = friend_contain.get(followerId);
        temp.remove(Integer.valueOf(followeeId));
        this.friend_contain.put(followerId, temp);
    }

    public void initialize(int userId) {
        user_pool.add(userId);
        tweet_contain.put(userId, new ArrayList<>());
        friend_contain.put(userId, new ArrayList<>());
    }
}
