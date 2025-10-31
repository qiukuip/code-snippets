class Solution20 {
    public boolean isValid(String s) {
        Map<Character, Character> map = Map.of('(', ')', '[', ']', '{', '}');
        char[] charArray = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : charArray) {
            if (map.containsKey(c)) {
                stack.push(c);
            } else if (map.containsValue(c)) {
                if (stack.isEmpty()) {
                    return false;
                }
                Character pop = stack.peek();
                if (c != map.get(pop)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
