class TimeMap {
    private final Map<String, List<TimestampedValue>> store;

    public TimeMap() {
        store = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        List<TimestampedValue> list;
        if (!store.containsKey(key)) {
            list = new ArrayList<>();
            store.put(key, list);
        } else {
            list = store.get(key);
        }

        list.add(new TimestampedValue(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if (!store.containsKey(key)) {
            return "";
        }

        List<TimestampedValue> list = store.get(key);

        int left = 0;
        int right = list.size() - 1;
        
        int mid = findMiddle(left, right);
        while (left < right) {
            if (timestamp < list.get(mid).timestamp) {
                right = mid - 1;
            } else if (timestamp == list.get(mid).timestamp) {
                return list.get(mid).value;
            } else {
                left = mid + 1;
            }

            mid = findMiddle(left, right);
        }

        if (mid < list.size() && timestamp == list.get(mid).timestamp) {
            return list.get(mid).value;
        }

        return list.get(list.size() - 1).value;
    }

    private int findMiddle(int left, int right) {
        int sum = left + right;
        if (sum % 2 == 0) {
            return (int) sum / 2;
        } else {
            return (int) (sum + 1) / 2;
        }
    }

    private class TimestampedValue {
        public final int timestamp;
        public final String value;

        public TimestampedValue(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }
}
