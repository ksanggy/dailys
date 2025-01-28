class Solution {
    // initial understanding of the problem was that it will only do a single round of vote.
    // based on the initial understanding, the best strategy was to ban the next opponent's vote
    // ---------------------------
    // In actality, the problem is saying the vote rounds have to be repeated until a winning senate group is set.
    // This is one of the key information apart from the requirements and constraints regarding bans.
    public String predictPartyVictory(String senate) {
        // FIFO DS to keep order of vote
        Queue<Character> votes = new LinkedList<>();
        // count of both senate parties
        int rCount = 0;
        int dCount = 0;
        for(Character c : senate.toCharArray()) {
            votes.add(c);
            if(c == 'R')
                rCount++;
            else
                dCount++;
        }

        // count of bans of senate parties
        int rBan = 0;
        int dBan = 0;
        while(rCount > 0 && dCount > 0) { // repeat while both parties have voting count
            char curr = votes.poll();
            
            if(curr == 'R') {
                if(rBan > 0) { // if there is a ban count for the 'R', lose vote
                    rBan--;
                    rCount--;
                }
                else {        // else re-queue to keep voting after banning oppposite party by 1
                    dBan++;
                    votes.add('R');
                }
            }
            else {
                if(dBan > 0) {
                    dBan--;
                    dCount--;
                }
                else {
                    rBan++;
                    votes.add('D');
                }
            }
        }

        return rCount > 0 ? "Radiant" : "Dire"; // the party with the remaining vote wins the senate
    }
}