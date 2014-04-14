DESCRIPTION = "Opera HbbTV browser"
PRIORITY = "optional"
LICENSE = "CLOSED"
SECTION = "base"

DEPENDS = "tslib mpfr gmp"
RREPLACES_{$PN} = "vuplus-opera-browser-util"
RCONFLICTS_{$PN} = "vuplus-opera-browser-util"
PACKAGES = "${PN}"

#SRC_DATE = "20140207_0"
SRC_DATE = "20130820_0"

SRC_URI = ""
SRC_FILE = "opera-hbbtv_${SRC_DATE}.tar.gz"

PR = "r7_${SRC_DATE}"

S = "${WORKDIR}/opera-hbbtv"

do_fetch() {
       if [ ! -e ${DL_DIR}/${SRC_FILE} -a -e /etc/vuplus_browser.pwd ]; then
sshpass -f /etc/vuplus_browser.pwd sftp -o StrictHostKeyChecking=no guestuser@code.vuplus.com << +
get ${SRC_FILE}
bye
+
       fi
       cp -av ${DL_DIR}/${SRC_FILE} ${WORKDIR}/
}

do_unpack() {
       tar xvfz ${SRC_FILE}
}

do_install() {
	install -d ${D}/usr/local/hbb-browser
	cp -avR ${S}/opera/* ${D}/usr/local/hbb-browser/

	install -d ${D}/etc
	cp -avR ${S}/dfb/etc/* ${D}/etc/

	install -d ${D}/usr/bin
	cp -avR ${S}/dfb/usr/bin/* ${D}/usr/bin/

	install -d ${D}/usr/lib
	cp -avR ${S}/dfb/usr/lib/* ${D}/usr/lib/

	install -d ${D}/usr/share
	cp -avR ${S}/dfb/usr/share/* ${D}/usr/share/
}

do_package_qa() {
}

INHIBIT_PACKAGE_STRIP = "1"

FILES_${PN} = "/usr/lib /usr/local /usr/share /usr/bin /etc "
