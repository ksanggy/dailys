import java.util.*;
class TimeMap {
    private final Map<String, List<ValueTimeStamp>> timeMap;
    public TimeMap() {
        timeMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if(!timeMap.containsKey(key)) {
            timeMap.put(key, new ArrayList<>());
        }
        ValueTimeStamp vts = new ValueTimeStamp(value, timestamp);
        timeMap.get(key).add(vts);
    }

    public String get(String key, int timestamp) {
        if(!timeMap.containsKey(key))
            return "";
        List<ValueTimeStamp> valueTimeStamps = timeMap.get(key);
        return search(valueTimeStamps, timestamp);
    }

    private String search( List<ValueTimeStamp> maps, int timestamp ) {
        int start = 0;
        int end = maps.size() - 1;
        while(start < end) {
            int middle = start + (end - start + 1) / 2;
            if(maps.get(middle).timeStamp() <= timestamp)
                start = middle;
            else
                end = middle - 1;
        }
        return maps.get(start).timeStamp() <= timestamp ? maps.get(start).value : "";
    }


    private record ValueTimeStamp( String value, int timeStamp ) {
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */