import tensorflow as tf
import urllib.request
#import cv2


def begin(name):
    # change this as you see fitg'
    image_path = "../../../../../resources/static/img/" + name + ".jpg"

    # Read in the image_data
    image_data = tf.gfile.FastGFile(image_path, 'rb').read()

    # Loads label file, strips off carriage return
    label_lines = [line.rstrip() for line
                   in tf.gfile.GFile("retrained_labels.txt")]

    # Unpersists graph from file
    with tf.gfile.FastGFile("retrained_graph.pb", 'rb') as f:
        graph_def = tf.GraphDef()
        graph_def.ParseFromString(f.read())
        _ = tf.import_graph_def(graph_def, name='')

    with tf.Session() as sess:
        # Feed the image_data as input to the graph and get first prediction
        softmax_tensor = sess.graph.get_tensor_by_name('final_result:0')

        predictions = sess.run(softmax_tensor, \
                               {'DecodeJpeg/contents:0': image_data})

        # Sort to show labels of first prediction in order of confidence
        top_k = predictions[0].argsort()[-len(predictions[0]):][::-1]
        list = []
        for node_id in top_k:
            human_string = label_lines[node_id]
            score = predictions[0][node_id]
            score = score * 100
            index = str(human_string) + ', ' + str(score)
            list.append(index)
            print('%s %.5f;' % (human_string, score))
    return list


def download(url, name):
    img = url
    urllib.request.urlretrieve(img, "../../../../../resources/static/img/" + name + ".jpg")


def downloadFace(url, name):
    img = url
    urllib.request.urlretrieve(img, "../../../../../../../target/classes/static/img/" + name + ".jpg")

def downloadStyle(url, name):
    img = url
    urllib.request.urlretrieve(img, "../../../../../../../target/classes/static/img/" + name + ".jpg")

"""
def facerec(name):
    face_cascade = cv2.CascadeClassifier('haarcascade_frontalface_default.xml')
    eye_cascade = cv2.CascadeClassifier('haarcascade_eye.xml')

    img = cv2.imread("../../../../../../../target/classes/static/img/" + name + ".jpg")
    gray = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)

    faces = face_cascade.detectMultiScale(gray, 1.3, 5)
    for (x, y, w, h) in faces:
        cv2.rectangle(img, (x, y), (x + w, y + h), (255, 0, 0), 2)
        roi_gray = gray[y:y + h, x:x + w]
        roi_color = img[y:y + h, x:x + w]
        # cv2.imshow('img',img)
        # cv2.waitKey(0)
        # cv2.destroyAllWindows()
    cv2.imwrite("../../../../../../../target/classes/static/img/" + name + "2.jpg", img)
    link = "/img/" + name + "2.jpg"
    return name + '2'
"""