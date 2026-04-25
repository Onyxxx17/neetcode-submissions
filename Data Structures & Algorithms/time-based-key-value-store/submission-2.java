class TimeMap {
    private Map<String,TreeMap<Integer,String>> map; 
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            TreeMap<Integer,String> tmap = new TreeMap<>();
            tmap.put(timestamp,value);
            map.put(key, tmap);
        } else{
            map.get(key).put(timestamp,value);
        }
    }
    
    public String get(String key, int timestamp) {
        TreeMap<Integer,String> timestamps = map.get(key);
        if(timestamps == null) return "";
        Map.Entry<Integer,String> entry = timestamps.floorEntry(timestamp);

        return entry == null ?  "" : entry.getValue();

    }
}
