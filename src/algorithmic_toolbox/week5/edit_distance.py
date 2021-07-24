def edit_dist(from_: str, to: str) -> int:
    table = [None] * (len(to) + 1)
    table = list(map(lambda x: [-1] * (len(from_) + 1), table))

    # init all base cases
    for i in range(len(to) + 1):
        table[i][0] = i

    for i in range(len(from_) + 1):
        table[0][i] = i

    # fill the table
    for r in range(1, len(to) + 1):
        for c in range(1, len(from_) + 1):
            min_dst = min(table[r][c - 1], table[r - 1][c - 1], table[r - 1][c])
            table[r][c] = min_dst if from_[c - 1] == to[r - 1] else min_dst + 1
    
    return table[len(to)][len(from_)]


if __name__ == '__main__':
    from_ = input()
    to = input()
    print(edit_dist(from_, to))
