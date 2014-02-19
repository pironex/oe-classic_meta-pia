#!/bin/sh

TSLIB_TSDEVICE="/dev/input/touchscreen0"

if [[ -e /dev/input/touchscreen0 ]] ; then 
    QWS_MOUSE_PROTO="tslib:/dev/input/touchscreen0 IntelliMouse:/dev/input/mouse1"
else
    QWS_MOUSE_PROTO="IntelliMouse:/dev/input/mouse0"
fi
export QWS_MOUSE_PROTO
export TSLIB_TSDEVICE

