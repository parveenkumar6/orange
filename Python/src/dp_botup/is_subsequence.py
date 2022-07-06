def is_subsequence(source, target):
    if len(source) == 0:
        return True
    dp = [[0] * (len(target) + 1) for _ in range(len(source) + 1)]
    for j in range(1, len(target) + 1):
        for i in range(1, len(source) + 1):
            if source[i - 1] == target[j - 1]:
                dp[i][j] = dp[i - 1][j- 1] + 1
            else:
                dp[i][j] = max(dp[i][j-1], dp[i-1][j])

        if dp[len(source)][j] == len(source):
            return True

    return False


ans = is_subsequence("abc", "addbiic")
print(ans)