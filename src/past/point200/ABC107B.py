h, w = [int(_) for _ in input().split()]
a = [input() for i in range(h)]
a = ["".join(row) for row in zip(*a) if row.count("#") > 0]
a = ["".join(row) for row in zip(*a) if row.count("#") > 0]
print("\n".join(a))
