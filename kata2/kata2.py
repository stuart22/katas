#Implement tests for all functions using unit tests


# #kata1a: Implement an algorithm to determine
#if a string has all unique characters.
#What if you cannot use additional data structures?

def unique_string(string):
    """(str) -> bool

    Return True if and only if all characters in the string are unique

    """

    dict = {}
    for letter in string:
        try:
            a = dict[letter]
            return False
        except:
            dict[letter] = 1
    return True

def unique_string_inplace(string):
    """(str) -> bool
     Return True if and only if all characters in the string are unique
     using no additional data structures

    """

    for x in range(0,len(string)):
        for y in range(0,len(string)):
            if x != y and string[x] == string[y]:
                return False

    return True



#kata1b: Implement a function `void reverse(char* str)` which reverses a null-terminated string.


def reverse_string(string):
    """(str) -> (str)

     Return the reverse of a string

     >>> reverse_string('abc')
     'cba'

     """
    revString = ""
    for letter in string:
        revString = letter + revString
    return revString


#kata1c: Given two strings, write a method to determine if one is a permutation of the other

def is_perm(str1, str2):
    """(str1, str2) -> bool
    Return true if and only if the second string is a permutation of the first.
    """

    if len(str1) != len(str2):
        return False

    dict1 = {}
    for letter in str1:
        try:
            a = dict1[letter]
            a += 1
            dict1[letter] = a
        except:
            dict1[letter] = 1

    for letter in str2:
        try:
            a = dict1[letter]
            if a == 0:
                return False
            a -= 1
            dict1[letter] = a
        except:
            return False

    return True

#kata1d: Implement a method to perform basic string compression using the counts of repeated characters.
#For example, the string `aabccccaaa` would become `a2b1c4a3`.
#If the compressed string would not become smaller than the original string your method should return the original string.
#You can assume the string has only lower and upper case characters (a-z).

def str_compress (string):
    """(str) -> (str)

    Return a string compression using the counts of repeated characters.

    >>> str_compress('aaabbbbcd')
    'a3b4c1d1'

    >>> str_compress('ab')
    'ab'

    """

    compString = ""
    curLetter = string[0]
    curCount = 1
    for letter in string[1:]:
        if letter == curLetter:
            curCount += 1
        else:
            compString = compString + curLetter + str(curCount)
            curLetter = letter
            curCount = 1
    compString = compString + curLetter + str(curCount)

    if len(compString) > len(string):
        return string
    return compString


import unittest

class TestStringMethods(unittest.TestCase):

    def test_unique(self):
        self.assertTrue(unique_string('abc'))
        self.assertFalse(unique_string('aabc'))
        self.assertFalse(unique_string('123,123'))
        self.assertFalse(unique_string('aabbcc1122'))


    def test_unique_inplace(self):
        self.assertTrue(unique_string_inplace('abc'))
        self.assertFalse(unique_string_inplace('aabc'))
        self.assertFalse(unique_string('123,123'))
        self.assertFalse(unique_string('aabbcc1122'))



    def test_reverse_string(self):
        self.assertEqual(reverse_string("abc"), "cba")
        self.assertEqual(reverse_string("bbb"), "bbb")
        self.assertEqual(reverse_string("123123"), "321321")
        self.assertEqual(reverse_string("a1b"), "b1a")
        self.assertEqual(reverse_string("1 1"), "1 1")

    def test_is_perm(self):
        self.assertTrue(is_perm("foo", "oof"))
        self.assertTrue(is_perm("fffo", "ffof"))
        self.assertFalse(is_perm("fof", "fffo"))
        self.assertFalse(is_perm("12345", "321"))
        self.assertTrue(is_perm("12", "21"))

    def test_str_compress(self):
        self.assertEqual(str_compress("ab"), "ab")
        self.assertEqual(str_compress("aaaabbc"), "a4b2c1")
        self.assertEqual(str_compress("aabbccaa"), "a2b2c2a2")


if __name__ == '__main__':
    unittest.main()
