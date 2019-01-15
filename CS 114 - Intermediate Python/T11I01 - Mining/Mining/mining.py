'''
@authors: Conor Murphy & Jose Saurez
'''

if __name__ == "__main__":
    import hashlib
    import time

    data = b"The quick brown fox jumps over the lazy dog."
    digits = input("Enter desired check digits: ")
    length = len(digits)
    print("length: " + str(len(digits)))
    bnum = 0
    nonce = 0
    result = ''
    start = time.perf_counter()
    while result[:length] != digits:
        h = hashlib.sha256()
        h.update(bytes(bnum))
        h.update(bytes(nonce))
        h.update(data)
        result = h.hexdigest()
        if result[:length] == digits:
            result = h.hexdigest()
        else:
            nonce += 1
    stop = time.perf_counter()
    total = str(stop - start)
    print("Found nonce: " + str(nonce) + "\nHash: " + result + "\nTime to compute: " + total)
