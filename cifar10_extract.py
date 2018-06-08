import mxnet as mx
import numpy as np
import _pickle as cPickle
import cv2

def extractInagesAndLabels(path, file):
    print(path)
    print(file)
    f = open(path+file,'rb')
    dict = cPickle.load(f, encoding='latin1')
    images = dict['data']
    images = np.reshape(images,(10000,3,32,32))
    labels = dict['labels']
    imagearray = mx.nd.array(images)
    labelarray = mx.nd.array(labels)
    return imagearray, labelarray

def extractCategories(path, file):
     f = open(path+file, 'rb')
     dict = cPickle.load(f, encoding='latin1')
     return dict['label_names']

def saveCifarImage(array, path, file):
    array = array.asnumpy().transpose(1,2,0)
    array = cv2.cvtColor(array, cv2.COLOR_RGB2BGR)
    return cv2.imwrite(path+file+".png", array)

imagearray,labelarray = extractInagesAndLabels("/home/mihir/cifar-10-batches-py/", "data_batch_1")
print (imagearray.shape)
print (labelarray.shape)
print("//////////")
print(imagearray)
categories = extractCategories("/home/mihir/cifar-10-batches-py/", "batches.meta")
print(categories)

cats = []
for i in range(0,10):
    saveCifarImage(imagearray[i], "./", "image"+(str)(i))
    category = labelarray[i].asnumpy()
    category = (int)(category[0])
    cats.append(categories[category])
print (cats)
