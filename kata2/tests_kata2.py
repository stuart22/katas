from kata2 import *

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

