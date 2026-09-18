class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<Pair> pairs = new ArrayList<>();
        for(int i = 0; i < position.length; i++){
            pairs.add(new Pair(position[i],speed[i]));
        }

        pairs.sort((p1, p2) -> Integer.compare(p2.position, p1.position));
        Stack<Double> cars = new Stack<>();
        for(Pair pair: pairs){
            double time = (target - pair.position)/(double) pair.speed;
            if(cars.isEmpty() || time > cars.peek()){
                cars.push(time);
            }
        }
        return cars.size();
    }

    class Pair{
        public Integer position;
        public Integer speed;
        
        public Pair(Integer position, Integer speed){
            this.position = position;
            this.speed = speed;
        }
    }
}
