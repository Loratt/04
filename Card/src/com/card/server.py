import json
import os

from couchdb import Server
import tornado.ioloop
import tornado.web
import tornado.websocket

class WebSocket(tornado.websocket.WebSocketHandler):
    def open(self):
        print('open')

    def on_message(self, message):
        print('on_message')
        if message == 'Place order':
            doc_id = db.save({'type': 'User'})
            self.write_message("OK")

    def on_close(self, message=None):
        print('on_close')

class Application(tornado.web.Application):
    def __init__(self):
        self.webSocketsPool = []
        handlers = (
            (r'/websocket/?', WebSocket),
            (r'/static/(.*)', tornado.web.StaticFileHandler,
             {'path': 'static/'}),
        )

        tornado.web.Application.__init__(self, handlers)

application = Application()

if __name__ == '__main__':
    connection = Server()
    db = connection['tornado-couch-testdb']
    application.listen(8888)
    tornado.ioloop.IOLoop.instance().start()