PR_append = "+pia010"

THISDIR := "${@os.path.dirname(bb.data.getVar('FILE', d, True))}"
#FILESPATHBASE_prepend := "${THISDIR}/peers:${THISDIR}/chats:"
FILESPATHBASE_prepend := "${THISDIR}:"

SRC_URI = " \
    file://peers/_gprs \
    file://peers/_gprs-ap-internet \
    file://chats/chat-gprs \
    file://peers/gprs \
    file://peers/umts \
    file://peers/gprs_cmux \
    file://peers/gprs_cmux_3.2 \
    file://chats/gprs \
    file://chats/umts \
    file://chats/pin.code \
    file://chats/pin.none \
"

# In worst case, user may need to edit anything
CONFFILES_${PN}_append = " \
	${sysconfdir}/ppp/peers/gprs ${sysconfdir}/ppp/chats/gprs \
	${sysconfdir}/ppp/peers/gprs ${sysconfdir}/ppp/chats/umts \
	${sysconfdir}/ppp/peers/gprs_cmux \
	${sysconfdir}/ppp/peers/gprs_cmux_3.2 \
	${sysconfdir}/ppp/peers/gprs ${sysconfdir}/ppp/chats/pin.code \
	${sysconfdir}/ppp/peers/gprs ${sysconfdir}/ppp/chats/pin.none "

do_install_append () {
    ln -s -T  pin.code ${D}/etc/ppp/chats/pin
}
