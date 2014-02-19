SUMMARY = "Utilities for transponder & dvb-s blindscan"
SECTION = "base"
PRIORITY = "optional"
RDEPENDS_${PN} = "ncurses"

LICENSE = "CLOSED"

PACKAGES = "sogno-blindscan-dvbs-utils sogno-blindscan-dvbs-utils-dbg sogno-blindscan-dvbc-utils sogno-blindscan-dvbc-utils-dbg"

PROVIDES += "virtual/blindscan-dvbs virtual/blindscan-dvbc"
RPROVIDES_sogno-blindscan-dvbs-utils += "virtual/blindscan-dvbs"
RPROVIDES_sogno-blindscan-dvbc-utils += "virtual/blindscan-dvbc"

SRC_URI = "http://archive.vuplus.com/download/utils/vuplus-blindscan-utils-${PV}.tar.bz2"

PV = "3.4"
PR = "r5"

S = "${WORKDIR}/blindscan-utils"

FILES_sogno-blindscan-dvbs-utils = "${bindir}/*_blindscan"
FILES_sogno-blindscan-dvbc-utils = "${bindir}/tda1002x ${bindir}/ssh108*"
FILES_sogno-blindscan-dvbs-utils-dbg = "${bindir}/.debug/*_blindscan"
FILES_sogno-blindscan-dvbc-utils-dbg = "${bindir}/.debug/tda1002x ${bindir}/.debug/ssh108*"

do_install() {
	install -d ${D}/${bindir}/
	for i in `find ${S} -type f -maxdepth 1`; do
		install -m 0755 $i ${D}/${bindir}/;
	done;
}

SRC_URI[md5sum] = "1266ec1ad53955144a06bc84a2ce497e"
SRC_URI[sha256sum] = "6f961e3645fbdb64972bf188b84c94489d784394b02362022d0f1a9fe9752a70"
