SRCREV= "6778b81c75b0693b34e88b40563f10e5d2f12474"

SRC_URI = "git://code.opencv.org/opencv_attic.git;protocol=git;branch=2.2 \
"
#           file://0001-SIFT-unbreak-non-android-ARM-builds.patch 
PV = "2.2.0+gitr${SRCPV}"
S = "${WORKDIR}/git/opencv"
