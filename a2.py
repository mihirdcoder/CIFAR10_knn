import xml.etree.ElementTree as tree
from threading import Thread

def partition(arr, low, high):
    pivot, i = arr[high], low
    for j in range(low, high):
        if(arr[j] <= pivot):
            arr[i], arr[j] = arr[j], arr[i]
            i += 1
    arr[i], arr[high] = arr[high], arr[i]
    return i

def quickSort(arr, low, high):
    if(low < high):
        p = partition(arr, low, high)
        t1 = Thread(target=quickSort(arr, low, p - 1))
        t2 = Thread(target=quickSort(arr, p + 1, high))
        t1.start()
        t2.start()
        t1.join()
        print (t1.getName())
        t2.join()
        print (t2.getName())

a = tree.parse("input.xml").getroot()
arr = map(int, a.text.split())
print ("Unsorted array: ", arr)
quickSort(arr, 0, len(arr) - 1)
print ("Sorted array: ", arr)
