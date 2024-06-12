class Solution {
    private int answer = 0;
    private int[] numbers;
    private int target;

    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;

        check(0, 0);

        return answer;
    }

    private void check(int depth, int sum) {
        if (depth == numbers.length) {
            if (sum == target) {
                answer++;
            }
            return;
        }

        check(depth + 1, sum + numbers[depth]);
        check(depth + 1, sum - numbers[depth]);
    }
}
