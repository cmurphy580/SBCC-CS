'''
Created on Oct 2, 2018

The QuakeList will use the magic/dunder methods
below to give it the functionality of a list.

@author: Conor Murphy
'''


class QuakeList:
    def __init__(self, ascending=True):
        self._ascending = ascending
        self._list = []
        self.index = -1

    def __iter__(self):
        return self

    def __next__(self):
        self.index += 1
        if self.index < len(self._list):
            return self._list[self.index]
        else:
            # raise a StopIteration if the end of the list is reached.
            raise StopIteration

    def __len__(self):
        return len(self._list)

    def __getitem__(self, index):
        return self._list[index]

    def __setitem__(self, key, value):
        return self._list.__setitem__(key, value)

    def append(self, quake):
        self._list.append(quake)
        # determine if the list is ascending or descending by
        # the argument passed through the QuakeList class
        if self._ascending is True:
            self._list.sort()
        else:
            self._list.sort(reverse=True)
