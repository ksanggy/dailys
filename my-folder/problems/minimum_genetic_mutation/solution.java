class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Queue<String> q = new LinkedList<>();   // For BFS
        Set<String> visited = new HashSet<>();  // To detect cycles/ loops

        int mutations=0;                        //To track each level in BFS
        q.add(start);                       //Add initial startGene to queue
        visited.add(start);                 //Add initial startGene to visited set

        while(!q.isEmpty()){
            int len = q.size();

            for(int i=0; i<len; i++){

                String checkGene = q.poll();
                if(checkGene.equals(end))
                    return mutations;
                
                for(String gene : bank){
                    int count  = calculateGeneChange(checkGene, gene);
                    if(count == 1 && !visited.contains(gene)){
                        q.add(gene);
                        visited.add(gene);
                    }    
                }
            }
            mutations++;
        }
        return -1;

    }

    public int calculateGeneChange(String a, String b){

        int count = 0;
        for(int i=0; i<8; i++){
            if(a.charAt(i) != b.charAt(i))
                count++;
        }
        return count;

    }
}