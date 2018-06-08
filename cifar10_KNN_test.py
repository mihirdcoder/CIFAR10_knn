import numpy as np
import pickle

def sort_key(dictionary):
    keys = list(dictionary.keys())
    keys.sort()

    sorted_dictionary = {}
    for key in keys:
        sorted_dictionary[key] = dictionary[key]

    return sorted_dictionary

def mdistance(x, y):
    return np.abs(np.sum(x-y))

def edistance(x, y):
    return np.sqrt(np.abs(np.sum((x-y)**2)))

def predict(data, test, distance):
    min_label = []
    min_label_value = []

    for index in data:
        for batch in data[index]:
            d = distance(batch, test)

            if len(min_label) < K:
                min_label.append(index)
                min_label_value.append(d)

            elif max(min_label_value) > d:
                i = np.argmax(min_label_value)
                min_label[i] = index
                min_label_value[i] = d
    return get_majority(min_label)

def get_batches(files, prefix = '' ):
    if type(files) is list:
        result = {}


        for file in files:
            data = {}

            with open(prefix + file, 'rb') as fo:
                data = pickle.load(fo, encoding='bytes')
               

            for i in range (len(data[b'labels'])):
                label = data[b'labels'][i]

                if label not in result:
                    result[label] = []

                result[label].append(data[b'data'][i])
            return sort_key(result)
    elif type(files) is str:
        result = {}
        data = {}

        with open(prefix + files, 'rb') as fo:
            data = pickle.load(fo, encoding= 'bytes')

        for i in range(len(data[b'labels'])):
            label = data[b'labels'][i]

            if label not in result:
                result[label] = []
            result[label].append(data[b'data'][i])

        return sort_key(result)



def get_majority(data):
    max_item = None
    max_value = None
    for item in set(data):
        tmp = 0
        for datum in data:
            if item is datum:
                tmp += 1

        if max_value is None or max_value < tmp:
            max_value = tmp
            max_item = item
    return max_item

K= 10
D= edistance


files = ['1','2','3','4','5']
images = get_batches(files, prefix= '/home/mihir/cifar-10-batches-py/data_batch_')

print("Batch: ")
print(type(images))

test_images = get_batches('test_batch', prefix = '/home/mihir/cifar-10-batches-py/')

result = []

for test_image_index in test_images:
    cnt = 0

    for batch in test_images[test_image_index]:
        label = predict(images, batch, distance = D)
        result.append(label is test_image_index)
        print("predict : %d, answer : %d"%(label, test_image_index))

        '''cnt += 1

        if cnt == 10:
            break'''

result_np = np.array(result, dtype='float32')
print("Average : %f"%np.mean(result_np))
