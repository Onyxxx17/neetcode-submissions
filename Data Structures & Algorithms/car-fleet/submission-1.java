class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<Pair> list = new ArrayList<>();
        Stack<Double> stack = new Stack<>();
        for(int i = 0; i < position.length; i++){
            list.add(new Pair(position[i],speed[i]));
        }

        list.sort((a,b) -> Integer.compare(b.key,a.key));

        for(int i = 0; i < list.size(); i++){
            double time = (target - list.get(i).key) / (double) list.get(i).value;
            
            if(stack.isEmpty() || time > stack.peek()){
                stack.push(time);
            }
        }

        return stack.size();
    }


    class Pair{
        public int key;
        public int value;

        public Pair(int key, int value){
            this.key = key;
            this.value = value;
        }        
    }
}
