package Miniorkut;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class UserProfile 
{
    private String username;
    private List<String> friends;

    public UserProfile(String username) 
    {
        this.username = username;
        this.friends = new ArrayList<>();
    }

    public String getUsername() 
    {
        return username;
    }

    public List<String> getFriends() 
    {
        return friends;
    }

    public void addFriend(String friendUsername)
    {
        friends.add(friendUsername);
    }

    public void removeFriend(String friendUsername) 
    {
        friends.remove(friendUsername);
    }
}

class MiniOrkut1 
{
    private Map<String, UserProfile> userProfiles;

    public MiniOrkut1() 
    {
        userProfiles = new HashMap<>();
    }

    public void createUserProfile(String username) 
    {
        if (!userProfiles.containsKey(username))
        {
            UserProfile userProfile = new UserProfile(username);
            userProfiles.put(username, userProfile);
            System.out.println("User profile created: " + username);
        } 
        else 
        {
            System.out.println("Username already exists!");
        }
    }

    public void addFriend(String username, String friendUsername) 
    {
        UserProfile userProfile = userProfiles.get(username);
        UserProfile friendProfile = userProfiles.get(friendUsername);

        if (userProfile != null && friendProfile != null) 
        {
            userProfile.addFriend(friendUsername);
            friendProfile.addFriend(username);
            System.out.println(username + " and " + friendUsername + " are now friends.");
        } 
        else
        {
            System.out.println("Invalid username(s)!");
        }
    }

    public void removeFriend(String username, String friendUsername)
    {
        UserProfile userProfile = userProfiles.get(username);
        UserProfile friendProfile = userProfiles.get(friendUsername);

        if (userProfile != null && friendProfile != null) 
        {
            userProfile.removeFriend(friendUsername);
            friendProfile.removeFriend(username);
            System.out.println(username + " and " + friendUsername + " are no longer friends.");
        } 
        else 
        {
            System.out.println("Invalid username(s)!");
        }
    }
}

 class MiniOrkut 
 {
    public static void main(String[] args) 
    {
        MiniOrkut1 miniOrkut = new MiniOrkut1();

        miniOrkut.createUserProfile("user1");
        miniOrkut.createUserProfile("user2");
        miniOrkut.createUserProfile("user3");

        miniOrkut.addFriend("user1", "user2");
        miniOrkut.addFriend("user2", "user3");

        miniOrkut.removeFriend("user1", "user2");
    }
}
