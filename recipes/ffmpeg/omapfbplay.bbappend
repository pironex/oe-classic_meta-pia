PR_append = "+pia001"

SRC_URI_append = " http://download.blender.org/peach/bigbuckbunny_movies/BigBuckBunny_320x180.mp4 "

do_install_append() {
	cp BigBuckBunny_320x180.mp4 ${D}/home/root/
}
