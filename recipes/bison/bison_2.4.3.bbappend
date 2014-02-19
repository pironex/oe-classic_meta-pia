PR = "${INC_PR}.2"

# workaround for older OE:
THISDIR := "${@os.path.dirname(bb.data.getVar('FILE', d, True))}"
FILESPATHBASE_prepend := "${THISDIR}/bison-2.4.3:"

SRC_URI += "\
    file://remove-gets.patch "