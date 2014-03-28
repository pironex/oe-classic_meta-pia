DESCRIPTION = "QTembedded related demos and packages for piA."
LICENSE = "MIT"
PR = "r007"

inherit task

RDEPENDS = ' \
	qt4-embedded-fonts \
	qt4-embedded-tools \
	qt4-embedded-qmlviewer \
	qt4-embedded-qml-plugins \
	qt4-embedded-plugin-imageformat-gif \
	qt4-embedded-plugin-imageformat-ico \
	qt4-embedded-plugin-imageformat-jpeg \
	qt4-embedded-plugin-imageformat-svg \
	qt4-embedded-plugin-imageformat-tiff \
	qt4-embedded-plugin-sqldriver-sqlite \
	qt4-embedded-plugin-sqldriver-sqlmysql \
	qt4-embedded-plugin-sqldriver-sqlpsql \
	opencv-samples \
'

# packages required for expansion boards, display
RRECOMMENDS = ' \
	qt4-embedded-demos qt4-embedded-examples \
	matrix-gui-e am-benchmarks am-sysinfo \
	qt-embedded-widgets-demo \
	ti-xgxperf-qt-embedded \
	qwt-e \	
'
# 	kernel-modules