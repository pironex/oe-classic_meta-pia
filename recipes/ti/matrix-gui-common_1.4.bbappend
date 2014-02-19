PR_append = "+pia010"

PLATFORM_pia-am35x = "pia35x"

SRC_URI = "git://192.168.1.90/apps/matrix-gui-bk.git;protocol=git"
SRCREV = "7f045cb6bd8cf7da57f1974384fd56f85437339d"

S = "${WORKDIR}/git"
INSANE_SKIP_${PN} = "ldflags"
