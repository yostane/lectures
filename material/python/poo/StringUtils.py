class StringUtils:
    
    @staticmethod
    def is_palindrome_method_1(s: str) -> bool:
        return s == s[::-1]
    
    @staticmethod
    def is_palindrome_method_2(s: str) -> bool:
        for i in range(len(s) // 2):
            if s[i] != s[-i-1]:
                return False
        return True
    
    @staticmethod
    def count_vowels_method_1(s: str) -> int:
        count = 0
        for c in s.lower():
            if c == "a" or c == "e" or c == "i" or c == "o" or c == "u" or c == "y":
                count += 1
        return count
    
    @staticmethod
    def count_vowels_method_2(s: str) -> int:
        count = 0
        for c in s.lower():
            if c in "aeiouy":
                count += 1
        return count

    @staticmethod
    def count_vowels_method_3(s: str) -> int:
        return len([c for c in s.lower() if c in "aeiouy"])

print(StringUtils.is_palindrome_method_1("Hello"))
print(StringUtils.is_palindrome_method_1("kayak"))

print(StringUtils.is_palindrome_method_2("Hello"))
print(StringUtils.is_palindrome_method_2("kayak"))

print(StringUtils.count_vowels_method_1("Python"), 
      StringUtils.count_vowels_method_2("Python"),
      StringUtils.count_vowels_method_3("Python"))

print("slicing")
numbers = [2, 5, -1, 6, 9, 11, 21]
print(numbers[::], numbers[::2], numbers[::-1], numbers[::-3])
print(numbers[1:5],numbers[1:], numbers[:4], numbers[:-2])
print(numbers[1:5:2], numbers[1:5:-1], numbers[5:1:-1], numbers[-2:0:-2])