/*
 * Copyright (c) 2018, CiBO Technologies, Inc.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * 3. Neither the name of the copyright holder nor the names of its contributors
 *    may be used to endorse or promote products derived from this software without
 *    specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.cibo.uidocumentation.example

import com.cibo.bedrock.ReactGridStrict._
import com.cibo.bedrock.elements.Icon
import com.cibo.uidocumentation.CodeExample
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

object IconExamplePage {

  def render() = {
    <.div(
      ^.cls := "style-guide",
      <.div(^.cls := "intro", <.div(^.cls := "interior", <.h4("Icons"))),
      <.div(
        ^.cls := "main-view",
        <.div(
          ^.cls := "example-block",
          row(
            column(12)(
              <.h4("Basic Icon Usage"),
              CodeExample("scala",
                          s"""
                   |Icon.iconName()
                   |Icon.iconName.size()
                 """.stripMargin)
            )
          ),
          row(
            column(12)(
              <.h4("Available Sizes"),
              row(Icon.keyboardArrowRight.small),
              row(CodeExample("scala", "Icon.keyboardArrowRight.small")),
              row(Icon.keyboardArrowRight()),
              row(CodeExample("scala", "Icon.keyboardArrowRight")),
              row(Icon.keyboardArrowRight.large),
              row(CodeExample("scala", "Icon.keyboardArrowRight.large")),
              row(Icon.keyboardArrowRight.extraLarge),
              row(CodeExample("scala", "Icon.keyboardArrowRight.extraLarge"))
            )
          ),
          row(
            column(12)(
              <.h4("Available Icons"),
              <.p(
                "Icons from Google's Material Design Icon Set. Library can be found ",
                <.a(^.href := "https://material.io/icons/", "here"),
                "."
              )
            )
          )
        )
      )
    )
  }

  val component = ScalaComponent.static("IconExample")(render())
}
