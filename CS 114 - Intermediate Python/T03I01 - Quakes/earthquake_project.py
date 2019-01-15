'''
Created on Sep 11, 2018

@author: Conor Murphy, William
'''
def parse_quake_data(data):
    for quake in data:
        print(quake)
    
if __name__ == '__main__':
    import sys, requests, csv;
    
    url = "https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_month.csv"
    resp = requests.get(url)
    if resp.status_code == 200:
        resp = resp.text.split()
        r = csv.DictReader(resp)
        
        parse_quake_data(r)
    
        sys.exit(0)