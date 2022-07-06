def can_cross(stones):
    if stones[1] != 1:
        return False
    dictionary = dict((x, set()) for x in stones)
    dictionary[1].add(1)

    for i in range(len(stones)):
        for j in dictionary[stones[i]]:
            for k in range(j - 1, j + 2):
                if k > 0 and stones[i] + k in dictionary:
                    dictionary[stones[i] + k].add(k)

    return dictionary[stones[-1]] != set()


ans = can_cross([0, 1, 3, 5, 6, 8, 12, 17])
print(ans)
