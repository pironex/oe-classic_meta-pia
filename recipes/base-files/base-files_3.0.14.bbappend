PR_append = "+pia011"

# workaround for older OE:
THISDIR := "${@os.path.dirname(bb.data.getVar('FILE', d, True))}"
FILESPATHBASE_prepend := "${THISDIR}/base-files:"

SRC_URI_append = " file://login-info.sh \
"

CONFFILES_${PN}_append = " ${sysconfdir}/profile.d/login-info.sh "

dirs755 += " /run \
"

do_install_append() {
    install -m 0755    ${WORKDIR}/login-info.sh   ${D}${sysconfdir}/profile.d/login-info.sh
}
