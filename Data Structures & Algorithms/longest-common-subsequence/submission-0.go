func longestCommonSubsequence(text1 string, text2 string) int {
    n := len(text1)
	m := len(text2)

	var dp [][]int = make([][]int, n + 1)

	for i, _ := range dp {
		dp[i] = make([]int, m + 1)
	}

	for i := 1; i < n + 1; i++ {
		for j := 1; j < m + 1; j++ {
			if text1[i - 1] == text2[j - 1] {
				dp[i][j] = dp[i - 1][j - 1] + 1
			} else {
				dp[i][j] = max(
					dp[i - 1][j],
					dp[i][j - 1],
				)
			}
		}
	}

	// disp(dp)

	return dp[n][m];
}

func disp(arr [][]int) {
	for _, row := range arr {
		for _, v := range row {
			fmt.Printf("%d, ", v)
		}
		fmt.Println()
	}
}
