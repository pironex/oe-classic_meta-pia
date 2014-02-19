PR_append = "+pia011"

PLATFORM_pia-am35x = "pia35x"

SRC_URI = "git://192.168.1.90/apps/matrix-gui-bk.git;protocol=git"
SRCREV = "96a185a398d0378a6840a685e3231052d4f33111"

S = "${WORKDIR}/git"

INSANE_SKIP_${PN} = "ldflags"
