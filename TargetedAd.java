public class TargetedAd {

    public static void main(String[] args) {
        // Step 2: Create a DataCollector object
        DataCollector dataCollector = new DataCollector();
        dataCollector.setData("socialMediaPosts.txt", "targetWords.txt");

        // Step 3: Initialize a String to hold the usernames
        String targetedUsers = "";

        // Step 4: Compare each user's post to the target words
        String post;
        while (!(post = dataCollector.getNextPost()).equals("NONE")) {
            // Extract username (first word of the post)
            String username = post.split(" ")[0];

            // Check if the post contains any target words
            for (String targetWord : dataCollector.getTargetWords()) {
                if (post.toLowerCase().contains(targetWord.toLowerCase())) {
                    targetedUsers += username + " ";
                    break; // Avoid duplicate entries for the same user
                }
            }
        }

        // Step 5: Prepare the advertisement file
        String advertisement = "We bet your furry friend would love to smell our pet food!";
        dataCollector.prepareAdvertisement("targetedUsers.txt", targetedUsers.trim(), advertisement);

        System.out.println("Targeted advertisement prepared and saved to targetedUsers.txt");



    }
}

