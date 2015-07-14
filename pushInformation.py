#-*- coding: utf-8 -*-
import xinge
import json

# 定义消息类
'''class HelpMessage:
    title = ''
    content = ''

    def __init__(self,x,y):
        self.title = x
        self.content = y
'''
# 定义通知
def BuildNotification():
    msg = xinge.Message()
    msg.type = xinge.Message.TYPE_NOTIFICATION
    msg.title = '求救信息'
    msg.content = '你收到一条求救信息，点击查看'
    # 消息为离线设备保存的时间，单位为秒。默认为0，表示只推在线设备
    msg.expireTime = 86400

    # 自定义键值对，key和value都必须是字符串，非必须
    #msg.custom = {'aaa':'111', 'bbb':'222'}
    # 使用多包名推送模式，详细说明参见文档和wiki，如果您不清楚该字段含义，则无需设置
    #msg.multiPkg = 
    
    # 通知展示样式，仅对通知有效
    # 样式编号为2，响铃，震动，不可从通知栏清除，不影响先前通知
    style = xinge.Style(2, 1, 1, 1, 0)
    msg.style = style
    
    # 点击动作设置，仅对通知有效
    # 以下例子为点击打开应用
    action = xinge.ClickAction()
    action.actionType = 1
    
    return msg

# 定义透传消息
def BuildMsg():
    msg = xinge.Message()
    msg.type = xinge.Message.TYPE_MESSAGE
    msg.title = 'some title'
    msg.content = 'some content'
    # 消息为离线设备保存的时间，单位为秒。默认为0，表示只推在线设备
    msg.expireTime = 86400
    # 定时推送，若不需定时可以不设置
    #msg.sendTime = '2012-12-12 18:48:00'
    # 自定义键值对，key和value都必须是字符串
    msg.custom = {'aaa':'111', 'bbb':'222'}
    # 使用多包名推送模式，详细说明参见文档和wiki，如果您不清楚该字段含义，则无需设置
    #msg.multiPkg = 1
    
    return msg

# 按app推送
def PushAll(x, msg):
    # 第三个参数environment仅在iOS下有效。ENV_DEV表示推送APNS开发环境
    ret = x.PushAllDevices(0, msg, xinge.XingeApp.ENV_DEV)
    print ret

if '__main__' == __name__:
    # 初始化app对象，设置有效的access id和secret key
    x = xinge.XingeApp(0, 'secret')
    #if (有求救信息)：
    # 构建消息，以通知的形式来通知在线用户
    noti = BuildNotification()
    # 对所有app推送信息
    PushAll(x, noti)
