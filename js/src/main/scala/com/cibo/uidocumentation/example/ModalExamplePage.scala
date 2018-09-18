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

import com.cibo.ui.{Margin, Padding}
import com.cibo.ui.ReactGridStrict.{column, row}
import com.cibo.ui.elements.{Button, Modals}
import com.cibo.ui.input.Form.{formElement, spreadForm}
import com.cibo.ui.input.{CheckBoxInput, TextInput, ToggleInput}
import com.cibo.ui.pane.{Pane, PaneHeader}
import japgolly.scalajs.react.{BackendScope, Callback, ScalaComponent}
import com.cibo.ui._
import com.cibo.ui.state.QuickStateWrapper
import japgolly.scalajs.react.vdom.html_<^._
import ReactGridStrict._
import com.cibo.uidocumentation.{CodeExample, SourceLink}
import com.cibo.uidocumentation.example.ThemingExamplePage.{changeCurrentTheme, themes}

object ModalExamplePage {

  case class Props()
  case class State()

  val exampleModalWrapper = new QuickStateWrapper[Boolean]
  class Backend(val $ : BackendScope[Props, State]) {

    def render(p: Props, s: State) = {
      <.div(
        ^.cls := "style-guide",
        <.div(^.cls := "intro", <.div(^.cls := "interior", <.h4("Theming"))),
        <.div(
          ^.cls := "main-view",
          row(
            column(12)(
            <.h4("Modal Example"),
              exampleModalWrapper.wrap(false){ case (curr, mod) =>
                column(12)(
                  Modals.wrapWithClosingPane(curr, () => {
                    mod(_ => false).runNow()
                  },
                    row(Padding(10), "Im a modal!".bold)
                  ),
                  Button("show modal")(^.onClick --> mod(_ => true))
                )
              }
            ),
            SourceLink.example("ModalExamplePage.scala")
          )
        )
      )


    }
  }

  private val component = ScalaComponent
    .builder[Props]("EnterpriseReport")
    .initialState(State())
    .renderBackend[Backend]
    .build

  def apply() = component(Props())
}
