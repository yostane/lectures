def f_that_throws(b):
    if b:
        return "Success"
    else:
        raise Exception()


print(f_that_throws(True))
# Crash si on n'attrape pas l'exception
# print(f_that_throws(False))

try:
    print(f_that_throws(True))
    print("Before")
    f_that_throws(False)
    print("After")
except Exception:
    print("Oups")
