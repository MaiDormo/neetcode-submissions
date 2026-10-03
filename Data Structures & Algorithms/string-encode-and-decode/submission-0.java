class Solution {

    private String key = "-0?1?0-";

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s: strs) {
            sb.append(s).append(key);
        }
        return sb.toString();

    }

    public List<String> decode(String str) {
        if (str.isEmpty()) return new ArrayList<>();
        String[] parts = str.split(Pattern.quote(key), -1);
        List<String> res = new ArrayList<>(Arrays.asList(parts));
        res.remove(res.size() - 1);
        return res;
    }
}
