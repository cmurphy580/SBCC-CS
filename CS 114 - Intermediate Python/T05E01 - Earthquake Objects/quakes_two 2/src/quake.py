'''
Created on Oct 2, 2018

The Quake class will take in the data from earthquake and assigned
it the attributes of the class. The magic methods
(or the dunder comparison methods) will be changed
to compare the magnitudes of the earthquake with another.

@author: Conor Murphy
'''

class Quake:
    def __init__(self, time, latitude, longitude, mag, place):
        self._time = time
        self._latitude = latitude
        self._longitude = longitude
        self._mag = float(mag)
        self._place = place

    def __str__(self):
        return f'[place: {self._place}, mag: {self._mag},
                  longitude: {self._longitude}, latitude: {self._latitude},
                  time: {self._time}]'

    def __eq__(self, other):
        return self._mag == other._mag

    def __ne__(self, other):
        return self._mag != other._mag

    def __lt__(self, other):
        return self._mag < other._mag

    def __gt__(self, other):
        return self._mag > other._mag

    def __le__(self, other):
        return self._mag <= other._mag

    def __ge__(self, other):
        return self._mag >= other._mag
