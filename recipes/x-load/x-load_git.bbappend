PR_append = "+pia002"
# TI PSP v1.46_OMAPPSP_03.00.01.06 (Tag is one commit different)
# git://arago-project.org/git/projects/x-load-omap3.git;protocol=git
#SRC_URI_pia-am35x = "git://github.com/craneboard/craneboard-xload.git;protocol=git \
SRC_URI_pia-am35x = "git://192.168.1.90/x-loader/x-loader.git;protocol=git"

SRCREV_pia-am35x = "0359a746608827c58d29ea4fc3567a587b0f7480"
PV_pia-am35x = "1.46+${PR}+gitr${SRCREV}"
