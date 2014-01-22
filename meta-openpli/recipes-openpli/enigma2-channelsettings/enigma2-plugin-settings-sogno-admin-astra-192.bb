DESCRIPTION = "SognoAdmin default SAT Settings 19"
MAINTAINER = "Sogno Team"
SECTION = "base"
LICENSE = "proprietary"
PACKAGE_ARCH = "all"

require conf/license/openpli-gplv2.inc

inherit gitpkgv
SRCREV = "${AUTOREV}"
PV = "3.0+git${SRCPV}"
PKGV = "3.0+git${GITPKGV}"
VER ="3.0"
PR = "r0"

SRC_URI="git://github.com/sogno/enigma2-plugin-settings-sogno-admin-astra-192"

S = "${WORKDIR}/git"

FILES_${PN} = "/etc/*"


do_install() {
	cp -rp ${S}/etc ${D}/
}