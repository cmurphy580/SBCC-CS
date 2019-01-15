'''
Created on Oct 2, 2018

@author: Conor Murphy
'''
from quake import Quake
from quakelist import QuakeList

if __name__ == '__main__':
    import sys
    import requests
    import csv
    # make request using url below to get earthquake data
    url = "https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_month.csv"
    req = requests.get(url)
    if req.status_code == 200:
        # if request is successfull split the text
        data = req.text.split()
        # then convert text into usuable data
        quakes = csv.DictReader(data)
        # a list of the ascending earthquake magnitudes using the QuakeList class
        ascending_list = QuakeList(ascending=True)
        # a list of descending earthquake magnitudes
        descending_list = QuakeList(ascending=False)
        # iterate through enumerate list of quakes
        for i, q in enumerate(quakes):
            # convert each quake into a Quake with the required attributes
            quake = Quake(q['time'], q['latitude'], q['longitude'], 
                          q['mag'], q['place'])
            # append each Quake the QuakeLists
            ascending_list.append(quake)
            descending_list.append(quake)
            if i > 20:
                break

        print("---Ascending---")
        print(f'Max of full set: {max(ascending_list._list)}')
        for quake in ascending_list[:10]:
            # print the first 10 Quakes in the ascending QuakeList
            print(quake)

        print("\n---Descending---")
        # Max of descending_list should equal the max of the ascending_list
        print(f'Max of full set: {max(descending_list._list)}')
        for quake in descending_list[:10]:
            # print the first 10 Quakes in the descending QuakeList
            print(quake)

    sys.exit(0)
