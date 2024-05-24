def find_combinations():
    combinations = []
    for i in range(10):
        for j in range(5):
            for k in range(3):
                if 5 * i + 10 * j + 20 * k == 45:
                    combinations.append((i, j, k))
    return combinations


combinations = find_combinations()
print(f"The combinations of 5, 10, and 20 that sum up to 45 are: {combinations}")
