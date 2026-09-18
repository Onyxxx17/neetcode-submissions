class TimeMap {

    Map<String,TreeMap<Integer,String>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            TreeMap<Integer,String> tMap = new TreeMap<>();
            tMap.put(timestamp, value);
            map.put(key,tMap);
        } else{
            map.get(key).put(timestamp,value);
        }
    }
    
    public String get(String key, int timestamp) {
        TreeMap<Integer,String> tMap = map.get(key);
        if(tMap == null) return "";
        Integer time = tMap.floorKey(timestamp);

        if(time == null) return "";
        return tMap.get(time);
    }
}
