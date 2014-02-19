PR_append = "+pia002"

do_install_prepend() {
	install -d ${D}${bindir} ${D}${mandir} ${D}${mandir}/man1/
}
